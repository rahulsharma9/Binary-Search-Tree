import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//C:\Users\rahul\Downloads\ass2_input.txt
public class TestTree {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		BinarySearchTree tree1 = new BinarySearchTree();
		
		Scanner input = new Scanner(System.in);
		boolean filefound = false;
		
		//Asking for a valid file address(path)
		while (!filefound)
		{
			try {
				System.out.println("Please enter the file location (path): ");
				Scanner fileInput = new Scanner(System.in);
				File file = new File(fileInput.next());
				input =  new Scanner(file);
				filefound = true;
			} catch (FileNotFoundException ex) {
				System.out.println("File does not exist please the specificed path and try again. ");
			}
		}
		
		System.out.println();
		
		//Creating string with file contents
		String str = "";
		while (input.hasNextLine()) {
			str = str + (input.nextLine());
		}
		str = str.replaceAll(" ", "");
			
		//Testing insert method
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String in = String.valueOf(ch);
			tree1.insert(in);
		}
		tree1.traverse();
		
		//Testing delete method
		tree1.delete("a");
		System.out.println();
		tree1.traverse();
		
		//Testing max method
		System.out.println("Max: " + tree1.getMax());
		System.out.println();
		
		//Testing min method
		System.out.println("Min: " + tree1.getMin());
		System.out.println();
		
		//Testing height method
		System.out.println("Does b exist? " + tree1.search("b", tree1.root));
		System.out.println();
		
		//Testing search method
		System.out.println("Height: " + tree1.findHeight(tree1.root));
		
		//Testing delete again
		tree1.delete("b");
		System.out.println();
		tree1.traverse();
		
		
		
	}

}
