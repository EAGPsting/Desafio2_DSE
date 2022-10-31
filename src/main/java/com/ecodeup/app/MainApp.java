package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Crud;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Crud crud;

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear Registro");
			System.out.println("2. Buscar Registro");
			System.out.println("3. Actualizar Registro");
			System.out.println("4. Eliminar Registro");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite el nombre de la persona:");
				crud = new Crud();
				crud.setId(null);
				scanner.nextLine();
				crud.setNombre(scanner.nextLine());

				System.out.println("Digite el apellido de la persona:");
				crud.setApellido(scanner.nextLine());
				
				System.out.println("Digite el telefono de la persona:");
				crud.setTelefono(scanner.nextLine());
				
				System.out.println("Digite el pais de la persona:");
				crud.setPais(scanner.nextLine());
				
				System.out.println("Digite el ciudad de la persona:");
				crud.setCiudad(scanner.nextLine());
				
				System.out.println("Digite el carnet de la persona:");
				crud.setCarnet(scanner.nextLine());
				
				System.out.println(crud);
				entity.getTransaction().begin();
				entity.persist(crud);
				entity.getTransaction().commit();
				
				System.out.println("crud registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del crud a buscar:");
				crud = new Crud();
				crud = entity.find(Crud.class, scanner.nextLong());
				if (crud != null) {
					System.out.println(crud);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("crud no encontrado... Lista de cruds completa");
					List<Crud> listacruds= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM crud p");
					listacruds=query.getResultList();
					for (Crud p : listacruds) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del crud a actualizar:");
				crud = new Crud();

				crud = entity.find(Crud.class, scanner.nextLong());
				if (crud != null) {
					System.out.println(crud);
					
					System.out.println("Digite el nombre del crud:");
					scanner.nextLine();
					crud.setNombre(scanner.nextLine());
					
					System.out.println("Digite el apellido de la persona:");
					crud.setApellido(scanner.nextLine());
					
					System.out.println("Digite el telefono de la persona:");
					crud.setTelefono(scanner.nextLine());
					
					System.out.println("Digite el pais de la persona:");
					crud.setPais(scanner.nextLine());
					
					System.out.println("Digite el ciudad de la persona:");
					crud.setCiudad(scanner.nextLine());
					
					System.out.println("Digite el carnet de la persona:");
					crud.setCarnet(scanner.nextLine());
					
					entity.getTransaction().begin();
					entity.merge(crud);
					entity.getTransaction().commit();
					System.out.println("crud actualizado..");
					System.out.println();
				} else {
					System.out.println("crud no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del crud a eliminar:");
				crud = new Crud();

				crud = entity.find(Crud.class, scanner.nextLong());
				if (crud != null) {
					System.out.println(crud);
					entity.getTransaction().begin();
					entity.remove(crud);
					entity.getTransaction().commit();
					System.out.println("crud eliminado...");
				} else {
					System.out.println("crud no encontrado...");
				}
				break;
			case 5:
				entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}