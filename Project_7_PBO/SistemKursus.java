import java.util.ArrayList;
import java.util.List;

interface sertifikat {
    void cetaksertifikat();
}

abstract class person {
    private String nama;

    public person(String nama) {
        this.nama =nama;
    }

    public String getNama() { return nama; }

    abstract void tampilkanperan();
}

    class Siswa extends person implements sertifikat {
        private String idSiswa;

        public Siswa(String nama, String idSiswa) {
            super(nama);
            this.idSiswa = idSiswa;
        }

        @Override
        void tampilkanperan(){
            System.out.println("Peran Siswa Aktif - ID: " + idSiswa);
        }

        @Override
        public void cetaksertifikat() {
            System.out.println("Mencetak sertifikat kelulusan untuk: " + getNama());
        }
    }

        class kelasIT<T extends person> {
            private String namakelas;

            private List<T> daftarpeserta = new ArrayList<>();

            public kelasIT(String namakelas) {
                this.namakelas = namakelas;
            }

            public void tambahpeserta(T peserta) {
                daftarpeserta.add(peserta);
            }

            public void tampilkanInfokelas() {
                System.out.println("=== KELAS: " + namakelas + " ===");
                for (T p : daftarpeserta) {
                    System.out.println("Nama: " + p.getNama() + " | ");
                    p.tampilkanperan();
                }
            }
        }

        public class SistemKursus {
            public static void main (String[] args) {

                kelasIT<Siswa> kelasJava = new kelasIT<>("Backend Java Developer");

                Siswa s1 = new Siswa("Fatur", "20240040262");
                Siswa s2 = new Siswa("Farda", "20240040109");
                Siswa s3 = new Siswa("Nazwa", "20240440050");

                kelasJava.tambahpeserta(s1);
                kelasJava.tambahpeserta(s2);
                kelasJava.tambahpeserta(s3);

                kelasJava.tampilkanInfokelas();

                System.out.println("\n---Fitur cetak ---");
            }
        }
    