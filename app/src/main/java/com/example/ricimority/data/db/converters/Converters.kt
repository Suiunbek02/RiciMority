package com.example.ricimority.data.db.converters


import androidx.room.TypeConverter
import com.example.ricimority.model.character.Location
import com.example.ricimority.model.character.Origin

class Converters {

    @TypeConverter
   fun fromLocation(model: Location): String {
       return model.name
   }

    @TypeConverter
    fun fromOrigin(model: Origin): String {
        return model.name
    }

    @TypeConverter
    fun toLocation(name: String): Location {
        return Location(name)
    }

    @TypeConverter
    fun toOrigin(name: String): Origin {
        return Origin(name)
    }
}
