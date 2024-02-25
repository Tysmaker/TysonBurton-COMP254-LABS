import java.io.File;

public class Exercise3 {

    public static void findFile(String path, String filename) {
        // Creating a File object to hold the current path
        File currentPath = new File(path);

        // Stores the list of file path entries
        File[] entries = currentPath.listFiles();

        // Check if entries exist
        if (entries != null) {
            // Iterate through each of the entires
            for (File entry : entries)
            {
                // Check if the entry is a directory
                if (entry.isDirectory())
                {
                    // Recursive call to find to search for subdirectories
                    findFile(entry.getAbsolutePath(), filename);
                }
                else
                {
                    // Check if the entry's name matches the target filename
                    if (entry.getName().equals(filename))
                    {
                        // Print the path of the file with the target filename
                        System.out.println("FilePath found at: " + entry.getAbsolutePath());
                    }
                    //Just adding some fail safes to check if the file name is not found to tell the user
                    else
                    {
                        System.out.println("FileName Not found!");
                    }
                }
            }
        }
        else
        {
            System.out.println("FilePath Not found!");
        }
    }

    public static void main(String[] args)
    {
        String filePath = "C:\\Users\\tyson\\OneDrive\\Desktop\\Lab3FilePath";
        String fileName = "Lab3TestFile.txt";

       //Calling the method and passing in my filePath and fileName as the arguments
        findFile(filePath, fileName);
    }
}
