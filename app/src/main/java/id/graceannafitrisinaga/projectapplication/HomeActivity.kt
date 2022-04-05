// nama paket
package id.graceannafitrisinaga.projectapplication

// mengimport content intent eksplisit maupun implisit agar dapat digunakan
import android.content.Intent
// mengimport ActionBar/Toolbar dan Material Design untuk mendesign activity di Android Studio
import androidx.appcompat.app.AppCompatActivity
// mengimport os bundle untuk membaca data dengan berbagai tipe data
import android.os.Bundle
// mengimport databinding ActivitHomeBinding pada projek projectapplication di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.projectapplication.databinding.ActivityHomeBinding

// Class Activity yang mengextend AppCompatActivity
class HomeActivity : AppCompatActivity() {

    // menginisialisasi variable binding pada ActivityHomeBinding
    lateinit var binding: ActivityHomeBinding

    // class Homectivity menyiapkan instance class binding dalam metode onCreate() agar dapat digunakan dengan suatu aktivitas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // mendefinisikan metode binding untuk menampilkan layout file activity_home.xml
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pada button Profile dengan id:btnProfile diatur OnClickListener agar saat button di-klik akan menjalankan aksi atau fungsi cekProfile()
        binding.btnProfile.setOnClickListener { cekProfile() }
        // pada button Logout dengan id:btnLogout diatur OnClickListener agar saat button di-klik akan menjalankan aksi atau fungsi cekLogout()
        binding.btnLogout.setOnClickListener {cekLogout()}

    }

    // fungsi cekProfile dijalankan ketika button Profile pada activity_home.xml diklik
      private fun cekProfile() {
          // menjalankan intent eksplisit
          // variabel intentp dari kelas intent menggunakan Inten ekspilisit yang akan meneruskan halaman sub class context yaitu HomeActivity ke class aktivitas tujuan yaitu ProfileActivity::class.java
          val  intentp = Intent (this, ProfileActivity::class.java)
          // memulai tampilan ProfileActivity yang ditentukan oleh Intentp
          startActivity(intentp)
    }
    // fungsi cekLogout dijalankan ketika button Logout pada activity_home.xml diklik
    private fun cekLogout() {
        // menjalankan intent eksplisit
        // variabel intentl dari kelas intent menggunakan Inten ekspilisit untuk kembali ke class MainActivity::class.java sebagai aktivitas tujuan
        val intentl = Intent (this, MainActivity::class.java)
        // memulai tampilan MainActivity yang ditentukan oleh Intentl
        startActivity(intentl)
    }
}