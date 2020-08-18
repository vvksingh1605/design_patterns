package BuilderPattern
fun main(){
    val smartPhone=SmartPhone.Builder("android").setColor("black").setWeight(140).build()
    print(smartPhone.os+" "+smartPhone.ramSize+"GB"+" "+smartPhone.color)

}

class SmartPhone private constructor(builder: Builder){
    val ramSize=builder.ramSize //Gb
    val os=builder.os //Gb
    val ScreenSize=builder.screenSize //inch
    val processor=builder.processor
    val weight=builder.weight //gm
    val color =builder.color

     class Builder(ostype:String){
        var os=ostype;// mandetory
        var screenSize=5.5 //inch
        var processor="snapDragon"
        var weight=150 //gm
        var color ="balck"
        var ramSize =3 //gb


        fun setScreenSize(screenSize: Double): Builder {
            this.screenSize = screenSize
            return this
        }

        fun setProcessor(processor: String): Builder {
            this.processor = processor
            return this
        }

        fun setWeight(weight: Int): Builder {
            this.weight = weight
            return this
        }

        fun setColor(color: String): Builder {
            this.color = color
            return this
        }
        fun build()= SmartPhone(this)


    }



}
