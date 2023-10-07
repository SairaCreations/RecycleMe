package com.sairacreations.recycleme

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recycle_values")

 data class RecycleValues(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,

    @ColumnInfo(name = "NAME_COL")
    val playerName: String,

    @ColumnInfo(name = "OBJ_TYPE")
    val objType: String,

    @ColumnInfo(name = "MATERIAL_TYPE")
    val materialType: String,

    @ColumnInfo(name = "SIZE_NUMBER")
    val size: Int,

    @ColumnInfo(name = "DATE_OF_RECYCLING")
    val dateOfRecycle: String,

    @ColumnInfo(name = "MULT_FACT")
    val multFact: Double)

{


}