package app.silentspark.silentspark.data

import app.silentspark.silentspark.dummy.DataDummy
import app.silentspark.silentspark.model.Course
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    
    private val listCourse = mutableListOf<Course>()

    init {
        if(listCourse.isEmpty()){
            DataDummy.listCouse.forEach {
                listCourse.add(it)
            }
        }
    }

    fun getAllCourse(): Flow<List<Course>> = flowOf(listCourse)
}



