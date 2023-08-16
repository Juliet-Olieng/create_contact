import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.juliet.contact2app.model.ContactData


class CustomTypeAdapter : TypeAdapter<ContactData>() {
    override fun write(out: JsonWriter, value: ContactData?) {
        value?.let {
            out.beginObject() // Start writing the object
            out.name("contactId").value(it.contactId)
            out.name("name").value(it.name)
            out.name("emailAddress").value(it.emailAddress)
            out.name("phoneNumber").value(it.phoneNumber)
            out.name("avatar").value(it.avatar)
            out.endObject() // End writing the object
        }
    }

    override fun read(`in`: JsonReader): ContactData {
        var contactId = 0
        var name = ""
        var emailAddress = ""
        var phoneNumber = ""
        var avatar = ""

        `in`.beginObject() // Start reading the object
        while (`in`.hasNext()) {
            when (`in`.nextName()) {
                "contactId" -> contactId = `in`.nextInt()
                "name" -> name = `in`.nextString()
                "emailAddress" -> emailAddress = `in`.nextString()
                "phoneNumber" -> phoneNumber = `in`.nextString()
                "avatar" -> avatar = `in`.nextString()
                else -> `in`.skipValue()
            }
        }
        `in`.endObject() // End reading the object

        return ContactData(contactId, name, emailAddress, phoneNumber, avatar)
    }
}

