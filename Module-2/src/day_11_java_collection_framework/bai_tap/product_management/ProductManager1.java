package day_11_java_collection_framework.bai_tap.product_management;

import java.util.*;

public class ProductManager1 {
    List<Product> listProduct = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public void add(Product product) {
        listProduct.add(product);
        System.out.println("Thanh cong them " + product);
    }

    public void update(int id) {
        for (Product p : listProduct) {
            if (p.getId() == id) {
                System.out.print("Nhap ten san pham: ");
                String name = sc.nextLine();
                System.out.println("Nhap gia san pham: ");
                float price = Float.parseFloat(sc.nextLine());
                p.setName(name);
                p.setPrice(price);
                System.out.println("Cap nhat san pham thanh cong. " + p);
                return;
            }
        }
        System.out.println("Khong ton tai san pham co id la " + id);
    }

    public void delete(int id) {
        for (Product p : listProduct) {
            if (p.getId() == id) {
                listProduct.remove(p);
                return;
            }
        }
        System.out.println("Khong ton tai san pham co id la " + id);
    }

    public void display() {
        for (Product p : listProduct) {
            System.out.println(p);
        }
    }

    public void search(String name) {
        for (Product p : listProduct) {
            if (p.getName().equals(name)) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Khong ton tai san pham co ten la " + name);
    }

    public void sort() {
        int choice;
        do {
            System.out.print("1. Sap xep theo gia tang dan\n" +
                    "2. Sap xep theo gia giam dan\n" +
                    "Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());
        } while (choice != 1 && choice != 2);
        Collections.sort(listProduct);
        if (choice == 2) {
            Collections.reverse(listProduct);
        }
    }

    public void run() {
        int choice;
        do {
            System.out.print("\nChon chuc nang trong menu:\n" +
                    "1. Them san pham\n" +
                    "2. Sua thong tin san pham\n" +
                    "3. Xoa san pham\n" +
                    "4. Hien thi danh sach san pham\n" +
                    "5. Tim kiem san pham\n" +
                    "6. Sap xep danh sach san pham\n" +
                    "0. Thoat\n" +
                    "Lua chon cua ban: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap id san pham moi: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap ten san pham moi: ");
                    String name = sc.nextLine();
                    System.out.print("Nhap gia san pham moi: ");
                    float price = Float.parseFloat(sc.nextLine());
                    add(new Product(id, name, price));
                    break;
                case 2:
                    System.out.print("Nhap id san pham can chinh sua: ");
                    int id1 = Integer.parseInt(sc.nextLine());
                    update(id1);
                    break;
                case 3:
                    System.out.print("Nhap id san pham can xoa: ");
                    int id2 = Integer.parseInt(sc.nextLine());
                    delete(id2);
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.print("Nhap ten san pham can tim: ");
                    String name1 = sc.nextLine();
                    search(name1);
                    break;
                case 6:
                    sort();
                    break;
                case 0:
                    return;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        ProductManager1 pm = new ProductManager1();
        pm.run();
    }
}
