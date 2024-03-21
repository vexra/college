/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package how.librarymanagement;

/**
 *
 * @author user
 */
public class Buku {
    private String isbn;
    private String judul;
    private String pengarang;
    private int stock;
    
    public Buku(String isbn, String judul, String pengarang, int stock) {
        this.isbn = isbn;
        this.judul = judul;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void addStock(int newStock) {
        this.stock += newStock;
    }
    
    public void reduceStock(int reduce) {
        if (this.stock < reduce) {
            System.out.println("Cannot reduce stock");
        } else {
            this.stock -= reduce;
        }
    }
    
    public boolean checkAvailability() {
        if (this.stock >= 1) return true;
        return false;
    }
}
