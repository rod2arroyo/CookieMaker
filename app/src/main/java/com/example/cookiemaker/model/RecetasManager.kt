package pe.edu.ulima.pm.ulgamestore.model

class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()

    init {
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
    }

    companion object {
        private var instance : RecetasManager? = null
    }

    fun getInstance() : RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas() : List<Receta> {
        /*val recipes = arrayListOf<Receta>()
        recipes.add(Receta(1,"Test 1","Test 1"))
        recipes.add(Receta(2,"Test 2","Test 2"))
        return recipes*/
        return mRecetas
    }

    fun addReceta(receta : Receta) {
        mRecetas.add(receta)
    }

    fun getReceta(id : Int) : Receta? {
        // Debe implementarlo !!!
        return null
    }

    fun getIngredientes() : ArrayList<Ingrediente> {
        return mIngredientes
    }



}