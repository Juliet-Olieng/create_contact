
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.juliet.contact2app.R
import com.juliet.contact2app.model.ContactData
import com.juliet.contact2app.viewModel.ContactsViewModel

class ContactDetailsActivity : AppCompatActivity() {
    private val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        val selectedContact: ContactData? = intent.getParcelableExtra("SELECTED_CONTACT")

        selectedContact?.let { contact ->
            val detailedContact = contactsViewModel.getContactById(contact.contactId)
            detailedContact?.let { detailed ->
                findViewById<TextView>(R.id.etName).text = detailed.toString()
                findViewById<TextView>(R.id.etNumber).text = detailed.toString()
            }
        }

    }
}

