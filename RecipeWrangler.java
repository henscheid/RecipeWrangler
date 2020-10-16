import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////////
//ALL STUDENTS COMPLETE THESE SECTIONS
//Title:            RecipeWrangler
//Files:            RecipeWrangler.java, RecipeBox.java, Recipe.java
//Semester:         CS302 Fall 2015
//
//Author:           Ian Henscheid
//Email:            henscheid@wisc.edu
//CS Login:         henscheid
//Lecturer's Name:  Jim Williams
//Lab Section:      341

public class RecipeWrangler {
	
	public static void main(String [] args) {
		
		//print out welcome message
		System.out.println("Recipe Wrangler 2015");
		System.out.println
			("Let us help you keep track of your favorite recipes.");
		
		//choice stores the user input when prompted in the main menu
		int choice = 0;
		
		//recipeBox stores all of the recipes in an Arraylist
		RecipeBox recipeBox = new RecipeBox();
		
		while (choice  != 5) {
			
			//scans for main menu input
			Scanner input = new Scanner(System.in);
			
			choice = 0;
			//print out menu
			System.out.print("Main Menu\n---------\n"
					+ "1. Display recipe names (sorted)"
					+ "\n2. Display/Edit/Add a recipe"
					+ "\n3. Load recipes from a file"
					+ "\n4. Save recipes to a file"
					+ "\n5. Exit"
					+ "\nEnter choice: ");
			
			do {
				// check for integer input
				if (input.hasNextInt()) {
					choice = input.nextInt();
					
					//prompts user to enter a valid option if an integer
					//outside of 1-5 is enter
					if (choice < 1 || choice > 5) {
						System.out.println
							("Enter integer choice between 1-5: ");
					}
					
				//if input is not an integer prompt user to enter valid choice	
				} else {
					System.out.println("Enter integer choice between 1-5: ");
					
				}
				input.nextLine();
				
			} while (choice < 1 || choice > 5 && choice != 5);
				
			
			//exit message
			if (choice == 5) {
				System.out.println("Thanks for using RecipeWrangler!");
			}
			//display sorted recipe names
			if (choice == 1) {
				recipeBox.sort();
				recipeBox.printRecipeList();
				
			}
			
			//display edit or add a recipe
			if (choice == 2) {
				
				//s records user input for option 2
				int s = 0;
				
				//get recipe name
				System.out.print("What is the name of the recipe? ");				
				
				//stores a recipe name in capital menus
				String name = input.nextLine().trim().toUpperCase();
				
				//checks name against all of the recipe names in recipeBox
				int recipeIndex = -1;
				for (int j = 0; j < recipeBox.recipeListSize(); j++ ) {
					
					//if recipe already exists store index of the recipe
					//in recipeIndex
					
					if (recipeBox.getRecipe(j).getName().equalsIgnoreCase(name)) 
						recipeIndex = j;
				}
				
				//if recipe already exists in recipeBox
				if (recipeIndex >= 0) {
					
					//get recipe at recipeIndex and store in recipe
					Recipe recipe = recipeBox.getRecipe(recipeIndex);
					
					//output recipe name, ingredients, instructions to user
					System.out.println("Found recipe for: " + name);
					System.out.println("Recipe name: " + name);
					System.out.println("Ingredients: " 
							+ recipe.getIngredients());
					System.out.println("Instructions: " 
							+ recipe.getInstructions());
					
					//while user doesn't input the done editing option
					//return to the edit recipe menu
					while (s != 3) {
						
						//display edit recipe menu
						System.out.println("1. Edit ingredients \n"
								+ "2. Edit instructions \n"
								+ "3. Done editing\n"
								+ "Enter Choice: ");
						
						if (input.hasNextInt()) {
							
							s = input.nextInt();
							
							if (s == 1 || s == 2) {
								input.nextLine();
								if (s == 1) {
									System.out.println
										("Enter the ingredients: ");
									
									//store user input in newIngredients
								
									String newIngredients = input.nextLine();
									recipe.setIngredients(newIngredients);
									
									//print out recipe with new ingredients
									System.out.println("Recipe name: " + 
											recipe.getName()
											+ "\nIngredients: " + 
											recipe.getIngredients()
											+ "\nInstructions: "+ 
											recipe.getInstructions());
		
								}
								
								else if (s == 2) {
									System.out.println
										("Enter the instructions: ");
									
									//store user input in newInstructions
									String newInstructions = input.nextLine();
									recipe.setInstructions(newInstructions);
									
									//print out recipe with new instructions
									System.out.println("Recipe name: " + 
											recipe.getName()
											+ "\nIngredients: " + 
											recipe.getIngredients()
											+ "\nInstructions: "+ 
											recipe.getInstructions());
									
								}
							//if s is not 1 or 2 exit the loop and return 
							//to the menu
							} else {
								break;
							}
						//if user doesn't enter an integer exit the loop and 
						//return to the menu
						} else {
							break;
						}
					} 
					
				//if recipe doesn't already exist in the recipeBox
				} else if (recipeIndex < 0) {
					//get recipe ingredients and instructions
					System.out.print("Adding recipe for: " + name);
					System.out.println("\nEnter the ingredients: ");
					String ingredients = input.nextLine();
					System.out.println("Enter the instructions: ");
					String instructions = input.nextLine();
					
					//create new recipe with info provided
					Recipe recipe = new Recipe(name, ingredients, instructions);
					recipeBox.add(recipe);
				}
			} 
			
			//Load recipes from file
			if (choice == 3) {
				
				//stores user entered filename
				String filename;

				
				System.out.println("Enter filename: ");
				
				filename = input.nextLine();
				
				
				File sourcefile = new File(filename);
				
				try {
					Scanner scnr = new Scanner(sourcefile);
					
					//stores number of recipes in file
					int numRecipes = scnr.nextInt();
					scnr.nextLine();
					
					//for each recipe in the file
					for (int i = 0; i < numRecipes; i++) {
						
						//stores each consecutive line in name, ingredients,
						//and instructions respectively and creates new recipe
						//with name, ingredients and instructions provided
						//by the user
						
						String name = scnr.nextLine().toUpperCase();
						String ingredients = scnr.nextLine();
						String instructions = scnr.nextLine();
						Recipe recipe = new Recipe(name, ingredients, instructions);
						
						//add new recipe to recipeBox
						recipeBox.add(recipe);
						System.out.println("Added " + name);
					}
					System.out.println("Added " + numRecipes + " recipes from " +
							filename);
					scnr.close();
					
					//if file doesn't exist print error message
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to read from file: " + filename);
					System.out.println("Added 0 recipes from " + filename);

				}

				
			}
			
			if (choice == 4) {
				
				String filename;
				System.out.println("Enter filename: ");
				
				filename = input.nextLine();
								
				File endfile = new File(filename);

				
				
				try {
					PrintWriter print = new PrintWriter(endfile);
					
					//for each recipe in recipeBox print out recipe name,
					//ingredients, and instructions on consecutive lines
					print.println(recipeBox.recipeListSize());
					for (int i = 0; i < recipeBox.recipeListSize(); i++) {
						Recipe recipe = recipeBox.getRecipe(i);
						print.println(recipe.getName());
						print.println(recipe.getIngredients());
						print.println(recipe.getInstructions());
						
					}
					print.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to write to file: " + filename);
					System.out.println("Saved 0 recipes to " + filename);

				}
	
			}
		}	
			
	}
}

