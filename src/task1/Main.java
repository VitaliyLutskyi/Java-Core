package task1;

interface Pet {
	void voice();
}

public class Main {

	public static void main(String[] args) {
			
		Pet cat = ()->System.out.println("� ��- �����-�����");
		Pet cow = ()->System.out.println("� ������- ����-����");
		Pet dog = ()->System.out.println("� ���-�����-�����");
		
		cat.voice();
		cow.voice();
		dog.voice();
	}

}
