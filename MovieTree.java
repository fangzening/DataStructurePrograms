public class MovieTree
{
    private class MovieNodeBST{
        private class MovieNodeLL{
            public int ranking;
            public String title;
            public int year;
            public int quantity;
            public MovieNodeLL next;
            public MovieNodeLL(){}
            public MovieNodeLL(int in_ranking, String in_title, int in_year, int 
in_quantity) {
                ranking = in_ranking;
                title = in_title;
                year = in_year;
                quantity = in_quantity;
                next = null;
            }
        }
        public char letter;
        public MovieNodeBST parent;
        public MovieNodeBST leftChild;
        public MovieNodeBST rightChild;
        public MovieNodeLL head;
        public MovieNodeBST(){}
        public MovieNodeBST(char in_letter) {
            letter = in_letter;
            parent = null;
            leftChild = null;
            rightChild = null;
            head = null;
        }
    }
    public MovieNodeBST root;
    public MovieTree() {
        // Your code here
        try {
            File movieList = new File("Assignment4Movies.txt");
            Scanner myReader = new Scanner(movieList);
            while (myReader.hasNextLine()) {
              String line = myReader.nextLine();
              System.out.println(line);
              String[] attribute = line.split(",");
              MovieNodeLL listNode = new MovieNodeLL(attribute[0], attribute[1],attribute[2], attribute[3]);
              MovieNodeBST treeNode = new MovieNodeBST(attribute[1].charAt(0));
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void printMovieInventory() {
        // Your code here
    }
    public int countMovieNodes() {
        // Your code here
    }
    public void deleteMovieNode(String title) {
        // Your code here
    }
    public void addMovieNode(int ranking, String title, int releaseYear, int 
quantity) {
        // Your code here
        char letter = title.charAt(0)
        MovieNodeBST cur = root
        MovieNodeBST parent = null
        while(cur != null) {
            parent = cur
            if (letter > cur.letter) {
                cur = cur.rightChild;
            } 
            else if (letter < cur.letter){
                cur = cur.leftChild;
            }
            else {
                // Found the letter in BST, append to linklist
                // TODO
                break;
            }
        }
        //MovieNodeLL listNode = new MovieNodeLL(attribute[0], attribute[1],attribute[2], attribute[3]);
        MovieNodeBST treeNode = new MovieNodeBST(attribute[1].charAt(0));
    }
    public void findMovie(String title) {
        // Your code here
    }
    public void rentMovie(String title) {
        // Your code here
    }
    private void DeleteAll(MovieNodeBSTnode) {
        //use this for the post-order traversal deletion of the tree
    }
    private void printMovieInventory(MovieNodeBST  node) {
    }
    private void countMovieNodes(MovieNodeBST node, int c) {
    }
    private MovieNodeBST searchBST(MovieNodeBST node, String title){
        //use this recursive function to find a reference to a node in the BST,
        //given a MOVIE TITLE
    }
    private MovieNodeLL searchLL(MovieNodeLL head, String title) {
        //use this to return a pointer to a node in a linked list,
        //given a MOVIE TITLE and the head of the linked list
    }
    private MovieNodeBST treeMinimum(MovieNodeBST node) {
        //use this to find the left most leaf node of the BST,
        //you'll need this in the delete function
    }
}