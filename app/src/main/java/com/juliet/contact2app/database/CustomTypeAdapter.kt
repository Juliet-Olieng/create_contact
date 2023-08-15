import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.juliet.contact2app.model.ContactData

class CustomTypeAdapter : TypeAdapter<ContactData>() {
    override fun write(out: JsonWriter, value: ContactData?) {
        value?.let {
            out.value(it.contactId)
        }
    }

    override fun read(`in`: JsonReader): ContactData {
        return ContactData(`in`.nextString())
    }
}
