package com.example.todoapp

object dataobject {
    var listdata= mutableListOf<Cardinfo>()
    fun setData(title:String,priority:String){
        listdata.add(Cardinfo(title,priority))
    }
    fun getALLDara():List<Cardinfo>{
        return listdata
    }
    fun deleteALL(){
        listdata.clear()
    }
    fun getData(pos: Int):Cardinfo{
        return listdata[pos]
    }
    fun deleteDATA(pos:Int){
        listdata.removeAt(pos)
    }
    fun updateData(pos:Int,title: String,priority: String){
        listdata[pos].title=title
        listdata[pos].priority=priority
    }
}