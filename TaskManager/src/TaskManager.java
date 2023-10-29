import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> taskList;
    private Scanner scanner;

    public TaskManager() {
        taskList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public class Task {
        private String deskripsi;

        public Task(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getDeskripsi() {
            return deskripsi;
        }
    }

    public void tambahTugas(Task task) {
        taskList.add(task);
    }

    public void editTugas(int indeks, Task task) {
        if (indeks >= 0 && indeks < taskList.size()) {
            taskList.set(indeks, task);
        }
    }

    public void hapusTugas(int indeks) {
        if (indeks >= 0 && indeks < taskList.size()) {
            taskList.remove(indeks);
        }
    }

    public void tampilkanTugas() {
        System.out.println("Daftar Tugas:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getDeskripsi());
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Edit Tugas");
            System.out.println("3. Hapus Tugas");
            System.out.println("4. Tampilkan Daftar Tugas");
            System.out.println("5. Keluar");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan deskripsi tugas baru: ");
                    String deskripsi = scanner.nextLine();
                    Task tugasBaru = taskManager.new Task(deskripsi);
                    taskManager.tambahTugas(tugasBaru);
                    System.out.println("Tugas berhasil ditambahkan.");
                    break;
                case 2:
                    taskManager.tampilkanTugas();
                    System.out.print("Masukkan indeks tugas yang akan diedit: ");
                    int indeksEdit = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    System.out.print("Masukkan deskripsi tugas yang baru: ");
                    String deskripsiBaru = scanner.nextLine();
                    Task tugasEdit = taskManager.new Task(deskripsiBaru);
                    taskManager.editTugas(indeksEdit - 1, tugasEdit);
                    System.out.println("Tugas berhasil diubah.");
                    break;
                case 3:
                    taskManager.tampilkanTugas();
                    System.out.print("Masukkan indeks tugas yang akan dihapus: ");
                    int indeksHapus = scanner.nextInt();
                    taskManager.hapusTugas(indeksHapus - 1);
                    System.out.println("Tugas berhasil dihapus.");
                    break;
                case 4:
                    taskManager.tampilkanTugas();
                    break;
                case 5:
                    berjalan = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
                    break;
            }
        }
    }
}
