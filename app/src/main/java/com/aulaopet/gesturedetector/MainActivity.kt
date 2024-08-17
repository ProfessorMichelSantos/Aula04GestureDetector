package com.aulaopet.gesturedetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat


class MainActivity : AppCompatActivity() {

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDetector = GestureDetectorCompat(this,GestureListener())


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // O usuário tocou a tela
                // Exemplo: Iniciar uma ação ou registrar a posição inicial
                Toast.makeText(this@MainActivity,"ACTION_DOWN",Toast.LENGTH_LONG).show()
                return true // Indica que o evento foi consumido
            }
            MotionEvent.ACTION_MOVE -> {
                // O usuário está movendo o dedo
                // Exemplo: Mover um objeto
                Toast.makeText(this@MainActivity,"ACTION_MOVE",Toast.LENGTH_LONG).show()
                return true // Indica que o evento foi consumido
            }
            MotionEvent.ACTION_UP -> {
                // O usuário levantou o dedo
                // Exemplo: Finalizar uma ação ou registrar a posição final
                Toast.makeText(this@MainActivity,"ACTION_UP",Toast.LENGTH_LONG).show()
                return true // Indica que o evento foi consumido
            }
            MotionEvent.ACTION_CANCEL -> {
                // O evento foi cancelado
                // Exemplo: Limpar estados ou redefinir configurações
                return true // Indica que o evento foi consumido
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                // Um novo ponto de contato foi adicionado
                // Exemplo: Iniciar um gesto multitouch
                val pointerIndex = event.actionIndex
                val pointerId = event.getPointerId(pointerIndex)
                val x = event.getX(pointerIndex)
                val y = event.getY(pointerIndex)
                Toast.makeText(this, "Novo ponto de contato: ID=$pointerId, X=$x, Y=$y", Toast.LENGTH_SHORT).show()
                return true
            }
            MotionEvent.ACTION_POINTER_UP -> {
                // Um ponto de contato foi removido
                // Exemplo: Finalizar um gesto multitouch
                Toast.makeText(this@MainActivity,"TIROU UM DEDO",Toast.LENGTH_LONG).show()
                return true // Indica que o evento foi consumido
            }
            else -> {
                // Outros tipos de eventos
                return super.onTouchEvent(event) // Permite que a classe base trate o evento
            }
        }
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener(){

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            Toast.makeText(this@MainActivity,"onfling",Toast.LENGTH_LONG).show()
            return super.onFling(e1, e2, velocityX, velocityY)
        }



        override fun onDoubleTap(e: MotionEvent): Boolean {
            Toast.makeText(this@MainActivity,"onDoubleTap",Toast.LENGTH_LONG).show()
            return super.onDoubleTap(e)
        }

        override fun onShowPress(e: MotionEvent) {
            Toast.makeText(this@MainActivity,"onShowPress",Toast.LENGTH_LONG).show()
            super.onShowPress(e)
        }
    }



}