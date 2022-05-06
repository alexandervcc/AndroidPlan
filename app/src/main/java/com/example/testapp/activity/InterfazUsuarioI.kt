package com.example.testapp.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.databinding.ActivityInterfazUsuarioIBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar

class InterfazUsuarioI : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityInterfazUsuarioIBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_interfaz_usuario_i)
        binding = ActivityInterfazUsuarioIBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonBinding2.setOnClickListener(){
            Toast.makeText(applicationContext,"Pulsaste el botón FLAT",Toast.LENGTH_LONG)
        }

        var str1:String = "String Var"
        binding.textViewBinding1.text = str1

        binding.btnLinux.setOnClickListener {
            Toast.makeText(applicationContext,"Pulsaste el botón Linux",Toast.LENGTH_LONG)
        }


        //RadioGroup
        var radioId = binding.radioGroup.checkedRadioButtonId

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            Log.i("Interfaz1","content: ${i}")
            when(i){
                R.id.radioButton ->Log.i("Interfaz1","content: ${i}")
                R.id.radioButton02 ->Log.i("Interfaz1","content: ${i}")
                else->Log.i("Interfaz1","nada seleccionado")
            }
        }

        //Switch
        var sw:Boolean = binding.switch2.isChecked
        binding.switch2.setOnClickListener {
            //TODO
        }

        //Checkbox
        var check1Value = binding.checkBox.isChecked

        //Snackbar
        Snackbar.make(view,"Sanck Example",Snackbar.LENGTH_SHORT)
            .setAction("ACEPTAR") {

            }
            .show()

        var sliderValue: Float? = null
        binding.continueSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: Slider) {
                sliderValue = binding.continueSlider.value
                Toast.makeText(applicationContext,"Slider value: ${sliderValue}",Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(slider: Slider) {
                sliderValue = binding.continueSlider.value
                Toast.makeText(applicationContext,"Slider value: ${sliderValue}",Toast.LENGTH_SHORT).show()
            }
        })

        binding.discretoSlider.addOnChangeListener { slider, value, fromUser ->
            when(value){
                10.0f->Toast.makeText(applicationContext,"Slider value: ${sliderValue}",Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Titulo")
                .setMessage("Mensaje ")
                .setNegativeButton("Cancel"){ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this,"Cancel Button",Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Acept"){ dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this,"Acept Button",Toast.LENGTH_SHORT).show()
                }
        }

        val lista = arrayOf("Ele1","ele2","ele3","ele4") //0,1,2,3
        MaterialAlertDialogBuilder(this)
            .setTitle("Titulo")
            .setMessage("Mensaje ")
            .setItems(lista){dialog,i->
                when(i){
                    0-> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
                    2-> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
                }
            }

        val datePickerMaterial = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Escoja la fecha")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePickerMaterial.addOnPositiveButtonClickListener {

        }

        //Dialog de seleccion por Radio Button
        val multiItems = arrayOf("Item 1", "Item 2", "Item 3")
        val checkedItems = booleanArrayOf(true, false, false, false)
        MaterialAlertDialogBuilder(this)
        //Multi-choice items (initialized with checked items)
        .setMultiChoiceItems(multiItems, checkedItems) { dialog, which, checked ->
            when(which){
                0-> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
                2-> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this,"Action 1",Toast.LENGTH_SHORT).show()
            }
        }
            .show()

    }


    override fun onClick(v: View?) {
        when (v) {
            binding.buttonBinding2 -> visualizarToast("OUTLINED")
            else -> {
                visualizarToast("OTRA COSA MARIPOSA")
            }
        }
    }

    fun visualizarToast(str: String) {
        Toast.makeText(this,"Pulsaste el botón ${str}",Toast.LENGTH_LONG).show()
    }
    fun visualizarToast2() {
        Toast.makeText(this,"Pulsaste el botón ",Toast.LENGTH_LONG).show()
    }
}