package com.sairacreations.recycleme




import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT, " +
                OBJ_TYPE + " TEXT, " +
                MATERIAL_TYPE + " TEXT, " +
                SIZE_NUMBER + " INTEGER, " +
                DATE_OF_RECYCLING + " DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                MULT_FACT + " REAL DEFAULT 1.0 " +


                ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addValues(name: String, obj: String, material: String, size_num: Int, multFact: Double){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(NAME_COL, name)
        values.put(OBJ_TYPE, obj)
        values.put(MATERIAL_TYPE, material)
        values.put(SIZE_NUMBER, size_num)
        values.put(MULT_FACT, multFact)
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // below method is to get
    // all data from our database
    fun getName(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT name FROM " + TABLE_NAME, null)

    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "RECYCLE_ME"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_NAME = "recycle_values"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val NAME_COL = "name"


        //is it a can or something else?
        val OBJ_TYPE = "object"

        //material- aluminum, glass?
        val MATERIAL_TYPE = "material"

        //size- number
        val SIZE_NUMBER = "size"

        //date of recycling- userful for retiring trees
        val DATE_OF_RECYCLING = "date_of_recycling"

        //trees- how many trees are there?
        val NUM_OF_TREES = "trees"

        //multiplication factor - for each o
        val MULT_FACT = "mult_fact"



    }
}
