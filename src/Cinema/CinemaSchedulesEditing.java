package Cinema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CinemaSchedulesEditing {
	
	public static Cinema work(Cinema cinema, Scanner s) throws FileNotFoundException, IOException {
		while (true) {
			System.out.println("\nВведіть 1 щоб додати фільм");
			System.out.println("Введіть 2 щоб додати сеанс");
			System.out.println("Введіть 3 щоб додати фільм разом з усіма його сеансами");
			System.out.println("Введіть 4 щоб видалити сеанс");
			System.out.println("Введіть 5 щоб видалити фільм разом з усіма його сеансами");
			System.out.println("Введіть 6 щоб подивитись розклад залу на певний день");
			System.out.println("Введіть 7 щоб подивитись список доступних фільмів");
			System.out.println("Введіть 8 щоб подивитись всі доступні сеанси фільму на тиждень");
			System.out.println("Введіть 9 щоб повернутись до попереднього меню");
			System.out.println("Введіть 0 щоб вийти");

			int n;
			Time duration, startTime;
			String hallName, title;
			Days day = null;
			Movie movie;
			
			while (true) {
				try {
					n = Integer.parseInt(s.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Ви повинні ввести ціле число від 0 до 9");
					continue;
				}
			}
			switch (n) {
			case 1:
				System.out.println("Введіть назву фільму");
				title = s.nextLine();
				duration = readTime("Введіть тривалість фільму у форматі hh:mm", s);
				cinema.addMovie(new Movie(title, duration));		
				break;
				
			case 2:
				movie = readMovie(cinema, s);
				if (movie != null) {
					hallName = readHall(cinema, s);
					if (hallName != null) {
						day = readDay(s);
						if(day != null) {
							startTime = readTime("Введіть час початку сеансу", s);
							try {
								cinema.addSeance(hallName, day, new Seance(movie, startTime));
							} catch (NotCorrectTimeException e) {
								System.out.println(e.getMessage());
							}
								
						}
					}
				}
				break;
				
			case 3:
				System.out.println("Введіть назву фільму");
				title = s.nextLine();
				duration = readTime("Введіть тривалість фільму у форматі hh:mm", s);
				hallName = readHall(cinema, s);
				if (hallName != null) {
					day = readDay(s);
					if (day != null) {
						String timesStr;
						while (true) {
							System.out.println("Введіть часи початків сеансів у форматі hh:mm через пробіл");
							timesStr = s.nextLine();
							// Remove double spaces
							while (timesStr.indexOf("  ") != -1)
								timesStr = timesStr.replace("  ", " ");
							if (!(timesStr.equals("") || timesStr.equals(" ") ))
								break;
						}
						String[] timesArr = timesStr.split(" ");
						Time[] times = new Time[timesArr.length];
						for (int i = 0; i < timesArr.length; i++) {
							try {
								times[i] = toTime(timesArr[i]);
							} catch (NotCorrectTimeException e) {
								System.out.println("Некоректно введено час. Правильно: 0..23год 0..59хв");
								break;
							} catch (Exception e) {
								System.out.println("Некоректно введено час.");
								break;
							}
						}
						cinema.addMovie(new Movie(title, duration), hallName, day, times);
					}
				}
				break;
				
			case 4:
				movie = readMovie(cinema, s);
				if (movie != null) {
					hallName = readHall(cinema, s);
					if (hallName != null) {
						day = readDay(s);
						if(day != null) {
							startTime = readTime("Введіть час початку сеансу", s);
							cinema.removeSeance(new Seance(movie, startTime), hallName, day);	
						}
					}
				}
				break;
				
			case 5:
				movie = readMovie(cinema, s);
				if (movie != null) {
					cinema.removeMovie(movie);
				}
				break;
				
			case 6:
				hallName = readHall(cinema, s);
				if (hallName != null) {
					day = readDay(s);
					if(day != null) 
						System.out.println("Розклад залу "+hallName+" на "+day+". "+cinema.getSchedule(hallName, day));
				}
				break;
				
			case 7:
				System.out.println("Доступні для перегляду фільми:");
				cinema.refreshMovies();
				cinema.getMovies().forEach(System.out::println);
				break;
				
			case 8:
				movie = readMovie(cinema, s);
				if (movie != null) {
					for(Hall h:cinema.getHalls()) {
						for (Days d:Days.values()) {
							h.getSchedules().get(d).getSeanceSet().stream().filter(sc->sc.getMovie().
									equals(movie)).forEach(sc->System.out.println(h.getName()+" зал "+d+" "+sc));
						}
					}
				}
				break;
			case 9: 
				return cinema;
			case 0:
				s.close();
				Main.save(cinema);
				System.exit(0);
				break;
			default:
				System.out.println("Число повинне бути від 0 до 9");
			}
		}
		
	}
	
	private static Movie readMovie(Cinema cinema, Scanner s) {
		Movie movie;
		System.out.println("Введіть назву фільму");
		String title= s.nextLine();
		movie = cinema.getMovieByTitle(title);
		if(movie == null) 
			System.out.println("Нема такого фільму");
		return movie;
	}
	
	private static String readHall(Cinema cinema, Scanner s) {
		String hallName;
		System.out.println("Введіть назву залу");
		hallName = s.nextLine();
		if(!(cinema.getHallNames().contains(hallName))) {
			System.out.println("Нема такого залу");
			hallName = null;
		}
		return hallName;
	}
	
	private static Days readDay(Scanner s) {
		Days day = null;
		System.out.println("Введіть день тижня");
		String dayName = s.nextLine();
		for(Days d:Days.values()) 
			if (d.name().equalsIgnoreCase(dayName))
				day=d;
		if(day == null) 
			System.out.println("Нема такого дня");
		return day;
	}
	
	public static Time readTime(String message, Scanner s) {
		Time time;
		while (true) {
			System.out.println(message);
			try {
				time = toTime(s.nextLine());
				break;
			} catch (NotCorrectTimeException e) {
				System.out.println("Некоректно введено час. Правильно: 0..23год 0..59хв");
			}
			catch (Exception e) {
				System.out.println("Некоректно введено час.");
			}
		}
		return time;
	}
	
	private static Time toTime(String s) {
		String[] split = s.split(":");
		int hours = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		return new Time(min,hours);
	}

}


































