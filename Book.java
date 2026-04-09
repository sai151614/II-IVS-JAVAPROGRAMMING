

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int quantity;
    private int availableQuantity;

    // Getters & Setters
    public int getBookId() 
      {
        return bookId; 
      }
    public void setBookId(int bookId)
     {
        this.bookId = bookId;
     }

    public String getTitle()
    {
       return title; 
    }
    public void setTitle(String title)
    { 
      this.title = title; 
    }

    public String getAuthor() 
    {
     return author; 
    }
    public void setAuthor(String author) 
    { 
       this.author = author;
    }

    public int getQuantity() 
    { 
        return quantity; 
    }
    public void setQuantity(int quantity) 
     { 
       this.quantity = quantity; 
    }

    public int getAvailableQuantity()
    { 
     return availableQuantity; 
  }
     public void setAvailableQuantity(int availableQuantity) 
   {
        this.availableQuantity = availableQuantity;
    }
}