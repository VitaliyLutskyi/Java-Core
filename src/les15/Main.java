package les15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ZooClub zooClub = new ZooClub();
		while(true) {
					
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n������ 0 ��� ����� � ��������");
			System.out.println("������ 1 ��� ������ �������� �����");
			System.out.println("������ 2 ��� ������ �������� �� �������� �����");
			System.out.println("������ 3 ��� �������� �������� � �������� �����");
			System.out.println("������ 4 ��� �������� �������� � �����");
			System.out.println("������ 5 ��� �������� ��������� �������� � ��� ��������");
			System.out.println("������ 6 ��� ������� �� ����� �������");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("�� ������ ������ ���� ����� �� 1 �� 6");
				continue;
			}
			
			switch(n) {
				case 0:
					System.exit(0);
				case 1:
					zooClub.addMember();
					break;
				case 2:
					zooClub.addPet();
					break;
				case 3:
					zooClub.removePet();
					break;
				case 4:
					zooClub.removeMember();
					break;
				case 5:
					zooClub.removePetFromAllMembers();
					break;
				case 6:
					System.out.println(zooClub);
					break;
			default: 
					System.out.println("����� ������� ���� �� 1 �� 6");
			}
				
			
			}

	}

}
