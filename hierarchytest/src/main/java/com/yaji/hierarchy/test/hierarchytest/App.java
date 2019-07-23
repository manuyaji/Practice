package com.yaji.hierarchy.test.hierarchytest;

import com.yaji.hierarchy.test.hierarchytest.helpers.Animal;
import com.yaji.hierarchy.test.hierarchytest.helpers.Dog;
import com.yaji.hierarchy.test.hierarchytest.helpers.DogPet;
import com.yaji.hierarchy.test.hierarchytest.helpers.Pet;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static void testInheritance(){
		Dog dog = new Dog();
		dog.setName("Blue");
		Animal animal = (Animal)dog;
		System.out.println(animal.getName());
	}
	
	// This works
	// Link: https://stackoverflow.com/questions/14694852/can-overridden-methods-differ-in-return-type
	private static void testMethodOverrideWithChildClassAsReturnType(){
		
		Dog dog = new Dog();
		dog.setName("Blue");
		Animal animal = (Animal)dog;
		System.out.println(animal.getName());
		
		DogPet dogPet = new DogPet();
		dogPet.setType(dog);
		Pet pet = (Pet) dogPet;
		System.out.println(pet.getType());
	}
	
    public static void main( String[] args )
    {
        testMethodOverrideWithChildClassAsReturnType();
    }
}
