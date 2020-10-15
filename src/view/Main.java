package view;

import controller.FileController;
import controller.PhoneNumberListManager;
import model.PhoneNumberList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String phoneNumberlistFile = "data.csv";
    public static void menu() {
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
        System.out.println("Chọn chức năng theo số (để tiếp tục: ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                PhoneNumberListManager.showList();
            }
            case 2 -> {
                String phoneNumber;

                do {
                    System.out.println("Nhập số điện thoại: ");
                    phoneNumber = scanner.nextLine();
                } while (!phoneNumber.matches("\\d{10}"));
                boolean isPhoneExist = PhoneNumberListManager.checkIsPhoneNumberExist(phoneNumber);
                if (!isPhoneExist) {
                    System.out.println("Nhập nhóm danh bạ :");
                    String phoneNumberGroup = scanner.nextLine();

                    System.out.println("Nhập họ tên: ");
                    String name = scanner.nextLine();

                    String[] genderList = {"nam", "nữ"};
                    int genderChoice;
                    do {
                        System.out.println("Nhập giới tính: \n1. nam\n2. nữ");
                        genderChoice = Integer.parseInt(scanner.nextLine());
                    } while (genderChoice < 1 || genderChoice > 2);
                    String gender = genderList[genderChoice - 1];

                    System.out.println("Nhập địa chỉ: ");
                    String address = scanner.nextLine();

                    String birthday;
                    do {
                        System.out.println("Nhập ngày sinh (dd\\mm\\yyyy): ");
                        birthday = scanner.nextLine();
                    } while (!birthday.matches("[0-9]{2}\\\\([0-9]{2})\\\\([0-9]{4})"));

                    String email;
                    do {
                        System.out.println("Nhập email: ");
                        email = scanner.nextLine();
                    } while (!email.matches("^(.*?)@gmail.com"));

                    PhoneNumberList phoneNumberList = new PhoneNumberList(phoneNumber, phoneNumberGroup, name, gender,
                            address, birthday, email);

                    PhoneNumberListManager.add(phoneNumberList);
                } else {
                    System.err.println("Số điện thoại này đã tồn tại");
                }

            }

            case 3 -> {
                String phoneNumber;
                boolean isPhoneNumberExist;
                do {
                    System.out.println("Nhập số điện thoại: ");
                    phoneNumber = scanner.nextLine();
                    isPhoneNumberExist = PhoneNumberListManager.checkIsPhoneNumberExist(phoneNumber);
                    if (!isPhoneNumberExist) {
                        System.err.println("“Không tìm được danh bạ với số điện thoại trên");
                    }
                } while (!phoneNumber.matches("\\d{10}") || !isPhoneNumberExist);
                if (isPhoneNumberExist) {
                    System.out.println("Nhập nhóm danh bạ :");
                    String phoneNumberGroup = scanner.nextLine();

                    System.out.println("Nhập họ tên: ");
                    String name = scanner.nextLine();

                    String[] genderList = {"nam", "nữ"};
                    int genderChoice;
                    do {
                        System.out.println("Nhập giới tính: \n1. nam\n2. nữ");
                        genderChoice = Integer.parseInt(scanner.nextLine());
                    } while (genderChoice < 1 || genderChoice > 2);
                    String gender = genderList[genderChoice - 1];

                    System.out.println("Nhập địa chỉ: ");
                    String address = scanner.nextLine();

                    String birthday;
                    do {
                        System.out.println("Nhập ngày sinh (dd\\mm\\yyyy): ");
                        birthday = scanner.nextLine();
                    } while (!birthday.matches("[0-9]{2}\\\\([0-9]{2})\\\\([0-9]{4})"));

                    String email;
                    do {
                        System.out.println("Nhập email: ");
                        email = scanner.nextLine();
                    } while (!email.matches("^(.*?)@gmail.com"));

                    PhoneNumberListManager.edit(phoneNumber, phoneNumberGroup, name, gender, address, birthday, email);
                }
            }

            case 4 -> {
                String phoneNumber;
                boolean isPhoneNumberExist;
                do {
                    System.out.println("Nhập số điện thoại: ");
                    phoneNumber = scanner.nextLine();
                    isPhoneNumberExist = PhoneNumberListManager.checkIsPhoneNumberExist(phoneNumber);
                    if (!isPhoneNumberExist) {
                        System.err.println("“Không tìm được danh bạ với số điện thoại trên");
                    }
                } while (!phoneNumber.matches("\\d{10}") || !isPhoneNumberExist);

               if (isPhoneNumberExist) {
                   System.out.println("Nhập Y để xác nhận xóa: ");
                   String yConfirm = scanner.nextLine();
                   if (yConfirm == "Y") {
                        PhoneNumberListManager.delete(phoneNumber);
                   } else {
                       return;
                   }
               }
            }

            case 5 -> {
                System.out.println("1. Tìm theo họ tên\n2. Tìm theo số điện thoại");
                int searchChoice = Integer.parseInt(scanner.nextLine());
                switch (searchChoice) {
                    case 1 -> {
                        System.out.println("Nhập tên muốn tìm: ");
                        String name = scanner.nextLine().toLowerCase();
                        PhoneNumberListManager.searchByName(name);
                    }
                    case 2 -> {
                        String phoneNumber;
                        do {
                            System.out.println("Nhập số điện thoại: ");
                            phoneNumber = scanner.nextLine();
                        } while (!phoneNumber.matches("\\d{10}"));
                        PhoneNumberListManager.searchByPhoneNum(phoneNumber);
                    }
                }
            }

            case 6 -> {
                System.out.println("Bạn có muốn cập nhật lại không? Điền Có/Không: ");
                String userConfirm = scanner.nextLine();
                switch (userConfirm) {
                    case "Có" -> {
                        PhoneNumberListManager.phoneNumberLists = FileController.readPhoneNumberListFromFile(phoneNumberlistFile);
                    }
                }

            }

            case 7 -> {
                System.out.println("Bạn có muốn lưu file không? Điền Có/Không: ");
                String userConfirm = scanner.nextLine();
                switch (userConfirm) {
                    case "Có" -> {
                        FileController.writePhoneNumberListToFile(PhoneNumberListManager.phoneNumberLists, phoneNumberlistFile);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }
}
