// nama paket
package id.graceannafitrisinaga.projectapplication

// mengimport content intent eksplisit maupun implisit agar dapat digunakan
import android.content.Intent
// mengimport komponen Uri di android studio agar dapat digunakan pada intent implisit
import android.net.Uri
// mengimport ActionBar/Toolbar dan Material Design untuk mendesign activity di Android Studio
import androidx.appcompat.app.AppCompatActivity
// mengimport os bundle untuk membaca data dengan berbagai tipe data
import android.os.Bundle
// mengimport databinding ActivitProfileBinding pada projek projectapplication di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.projectapplication.databinding.ActivityProfileBinding

// Class Activity yang mengextend AppCompatActivity
class ProfileActivity : AppCompatActivity() {

    // menggunakan object pendamping yang berkaitan dengan class ProfileActivity,
    // dan kita tidak perlu memberinya nama jenis yang terpisah.
    companion object {
        // menambahkan properti untuk konstanta link
        // dimana URL yang digunakan pada konstanta link ini nantinya akan mengarah ke halaman web linkedin
        // dan ditampilkan pada halaman activity_profile
        const val LINK = "https://www.linkedin.com/in/grace-anna-58b42b218/"
    }

    // menginisialisasi variable binding pada ActivityProfileBinding
    lateinit var binding: ActivityProfileBinding

    // class ProfileActivity menyiapkan instance class binding dalam metode onCreate() agar dapat digunakan dengan suatu aktivitas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // mendefinisikan konsep/metode binding untuk menampilkan layout file activity_profile.xml
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pada button Back dengan id:btnBack diatur OnClickListener agar saat button di-klik akan menjalankan aksi atau fungsi cekBack()
        binding.btnBack.setOnClickListener { cekBack() }
        // pada button Link dengan id:btnLink diatur OnClickListener agar saat button di-klik akan menjalankan aksi atau fungsi cekLinkedIn()
        binding.btnLink.setOnClickListener { cekLinkedIn() }
    }

    // fungsi cekBack dijalankan ketika button BACK pada activity_profile.xml diklik
    private fun cekBack() {
        // menjalankan intent eksplisit
        // variabel intentb dari kelas intent menggunakan Inten ekspilisit untuk kembali ke class HomeActivity::class.java sebagai aktivitas tujuan
        val  intentb = Intent (this, HomeActivity::class.java)
        // memulai tampilan HomeActivity yang ditentukan oleh Intentb
        startActivity(intentb)
    }

    // fungsi cekLinkedIn dijalankan ketika button LINKEDIN pada activity_profile.xml diklik
    private fun cekLinkedIn() {
        // menjalankan intent implisit
        // membuat Uri dengan variabel queryUrl untuk memanggil parse link sebagai kueri penelusuran
        val queryUrl: Uri = Uri.parse(LINK)
        // menginisialisasi objek intent baru dengan meneruskan Intent.ACTION_VIEW bersama dengan URI yang terdapat dalam variabel queryURL.
        // ACTION_VIEW adalah intent umum yang menggunakan URI yaitu alamat web.
        // Sistem akan mengetahui cara memproses intent ini dengan membuka URI di browser web pengguna.
        val intent = Intent(Intent.ACTION_VIEW, queryUrl)
        // memulai tampilan halaman web sesuai dengan URL yang digunakan dalam konstanta LINK oleh Intent
        startActivity(intent)
    }
}