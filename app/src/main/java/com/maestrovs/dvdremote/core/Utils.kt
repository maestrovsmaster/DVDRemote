package com.maestrovs.dvdremote.core

val FREQUENCY = 38222

class binHexDec(char: Char){
    val c = char
    val hexa : ArrayList<Char> = arrayListOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')

    fun hexToBin():String{

        val bina : ArrayList<String> = arrayListOf("0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111")
        return bina[hexa.indexOf(c)]
    }
}

fun decToHex(string: String):String{
    val hexa : ArrayList<Char> = arrayListOf('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')

    var reste: String = ""
    var nb = string.toInt()
    while (nb / 16 != 0){
        reste += hexa[nb % 16].toString()
        nb = nb / 16
    }
    reste += hexa[nb % 16].toString()
    return reste.reversed()
}

/*
function to create the signal:
    it's a NEC signal
 */
fun irHexComToSig(hexCommand:String): ArrayList<Int> {
    var signals = arrayListOf<Int>()

    signals.add(9000)
    signals.add(4500)



    for (l in hexCommand.asIterable()){
        for (n in binHexDec(l).hexToBin()){
            if (n.toString().toInt() == 0) {
                signals.add(562)
                signals.add(562)
            }else{
                signals.add(562)
                signals.add(1687)
            }
        }
    }

    signals.add(40000)

    return signals
}
