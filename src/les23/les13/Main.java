package les23.les13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Parliament parliament = Parliament.getParliament();
		while(true) {
			
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n������ 0 ��� �����");
			System.out.println("������ 1 ��� ������ �������");
			System.out.println("������ 2 ��� �������� ��������� �������");
			System.out.println("������ 3 ��� ������� ��  �������");
			System.out.println("������ 4 ��� �������� ��������� �������");
			System.out.println("������ 5 ��� ������� ��������� �������");
			System.out.println("������ 6 ��� ������ �������� � �������");
			System.out.println("������ 7 ��� �������� �������� � �������");
			System.out.println("������ 8 ��� ������� ������ ���������");
			System.out.println("������ 9 ��� ������� ���������� ���������");
			
			int n;
			try {
				n = s.nextInt();
			}
			catch(Exception e) {
				System.out.println("�� ������ ������ ���� ����� �� 1 �� 9");
				continue;
			}
			
			switch(n) {
				case 0:
					return;
				case 1:
					parliament.addFaction();
					break;
				case 2:
					parliament.removeFaction();;
					break;
				case 3:
					parliament.outputAllFactions();;
					break;
				case 4:
					parliament.clearFaction();
					break;
				case 5:
					parliament.outputFactionDeputies();
					break;
				case 6:
					parliament.addDeputy();
					break;
				case 7:
					parliament.removeDeputy();
					break;
				case 8:
					System.out.println("������ ���������:");
					parliament.getFactions().stream().forEach(Faction::outputBribeTakers);
					break;
				case 9:
					Faction allDep = new Faction("�� ��������");
					
					parliament.getFactions().stream().forEach(f->allDep.getDeputies().addAll(f.getDeputies()));
					allDep.outputBiggestBribeTaker();
					break;
				default:
					System.out.println("����� ������� ���� �� 1 �� 9");
			}
		}

	}

}
