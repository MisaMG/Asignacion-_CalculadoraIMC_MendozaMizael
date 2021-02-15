package mendoza.misael.asignacion4_calculadoraimc_mendozamisael

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var kilos: Double = 0.00
    var estatura: Double = 0.00
    var valorIMC: Double = kilos / estatura

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val profile: ImageView = findViewById(R.id.profile)
        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val calcular: Button = findViewById(R.id.calcular)
        val imc: TextView = findViewById(R.id.imc)
        val range: TextView = findViewById(R.id.range)


        weight.setOnClickListener {
            kilos = readLine()!!.toDouble()
            println(kilos)
        }

        height.setOnClickListener {
            estatura = readLine()!!.toDouble()
            println(estatura)
        }

        calcular.setOnClickListener {
            imc.setText(valorIMC.toString())
        }

        fun calcularRango(valorIMC: Double){
            if ( valorIMC in 0.00..18.5){
                range.setText("Bajo Peso")
                range.setBackgroundResource(R.color.colorGreen)
            } else if (valorIMC in 18.6..24.9) {
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreenish)
            } else if ( valorIMC in 25.0..29.9){
                range.setText("Sobrepeso")
                range.setBackgroundResource(R.color.colorYellow)
            } else if ( valorIMC in 30.0..34.9){
                range.setText("Obesidad grado 1")
                range.setBackgroundResource(R.color.colorOrange)
            } else if ( valorIMC in 35.0..39.9){
                range.setText("Obesidad grado 2")
                range.setBackgroundResource(R.color.colorRed)
            }else if ( valorIMC >= 40){
                range.setText("Obesidad grado 3")
                range.setBackgroundResource(R.color.colorBrown)
            }

        }
    }
}

