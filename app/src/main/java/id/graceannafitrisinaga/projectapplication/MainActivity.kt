// nama paket
package id.graceannafitrisinaga.projectapplication

// mengimport content intent eksplisit maupun implisit agar dapat digunakan
import android.content.Intent
// mengimport ActionBar/Toolbar dan Material Design untuk mendesign activity di Android Studio
import androidx.appcompat.app.AppCompatActivity
// mengimport os bundle untuk membaca data dengan berbagai tipe
import android.os.Bundle
// mengimport widget toast/pop up agar dapat digunakan pada aplikasi android
import android.widget.Toast
// mengimport databinding ActivitMainBinding pada projek projectapplication di paket id.graceannafitrisinaga
import id.graceannafitrisinaga.projectapplication.databinding.ActivityMainBinding

// Class Activity yang mengextend AppCompatActivity.
class MainActivity : AppCompatActivity() {

    // menginisialisasi variable binding pada ActivityMainBinding
    lateinit var binding: ActivityMainBinding

    // class MainActivity menyiapkan instance class binding dalam metode onCreate() agar dapat digunakan dengan suatu aktivitas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // konsep/metode binding didefinisikan untuk menampilkan layout file activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // pada button Login dengan id:btnLogin diatur sebuah OnClickListener agar saat button di-klik akan menjalankan aksi atau fungsi cekLogin()
        binding.btnLogin.setOnClickListener { cekLogin() }
    }

    // fungsi cekLogin() ini digunakan sebagai validasi data username dan password yang diinput user
    private fun cekLogin() {
        // mengambil data yang diinputkan user pada widget EditText dengan id/editTextusername yang dikonversi ke String dan dimasukkan ke dalam variabel userName
        val userName = binding.editTextusername.text.toString()
        // mengambil data yang diinputkan user pada widget EditText dengan id/editTextpassword yang dikonversi ke String dan dimasukkan ke dalam variabel password
        val password = binding.editTextpassword.text.toString()

        // seleksi if digunakan untuk mencek kondisi apakah variabel userName kosong atau variabel password kosong
        // jika benar akan menampilkan toast/pop-up
        if (userName.isEmpty() || password.isEmpty()) {
            // jika salah satu dari kondisi if ini bernilai benar (variabel username atau variabel password tidak diisi oleh user
                // maka pop up atau toast akan dimunculkan dengan pesan 'Username or Password Must Be Required!!' pada halaman MainActivity
            Toast.makeText(this, "Username or Password Must Be Required!!", Toast.LENGTH_SHORT).show()
            return
        }

        // Seleksi if yang kedua digunakan untuk mencek apakah inputan user pada id/editTextusername dan id/editTextpassword sudah sesuai dengan kondisi seleksi if ini
        // kondisi yang digunakan adalah jika variabel userName yang diinput sama dengan 'GraceAFS' dan variabel password yang diinput sama dengan 'grace25'
        if (userName == "GraceAFS" && password == "grace25") {
            // maka intent eksplisit akan dijalankan
                // dimana variabel intent menggunakan Inten ekspilisit yang akan meneruskan halaman sub class context yaitu MainActivity ke class aktivitas tujuan yaitu HomeActivity::class.java
            val intent = Intent(this, HomeActivity::class.java)
            // menambah data dengan parameter key yaitu id/editTextusername (data yang akan diambil) dan value userName (data yang akan dikirim) ke intent
            intent.putExtra("user_name", binding.editTextusername.text.toString())
            // memulai tampilan HomeActivity yang ditentukan oleh Intent
            startActivity(intent)

        // jika inputan username dan password tidak sesuai dengan kondisi if maka perintah else akan dijalankan
        } else {
            // pop up atau toast akan dimunculkan dengan pesan 'Username or Password False!!' pada halaman MainActivity
            Toast.makeText(this, "Username or Password False!!", Toast.LENGTH_SHORT).show()
            return
        }
    }
}
