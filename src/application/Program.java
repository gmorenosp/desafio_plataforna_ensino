package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.printf("Dados da %da aula:\n", i+1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String titulo = sc.nextLine();
			
			if(tipo == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				Integer duracao = sc.nextInt();
				list.add(new Video(titulo, url, duracao));
			}
			else {
				System.out.print("Descrição: ");
				String descricao = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				Integer questoes = sc.nextInt();
				list.add(new Task(titulo, descricao, questoes));
			}
		}

		System.out.println();
		int soma=0;
		for (Lesson lesson : list) {
			soma += lesson.duration();
		}
		
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + soma + " segundos");
		
		sc.close();
	}
}
