package com.example.module2_file2_ex7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2_file2_ex7.ui.theme.Module2_file2_ex6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2_file2_ex6Theme {
                val c = Contact("Евгений","Андреевич","Лукашин","+7 495 495 95 95","г. Москва, 3-я улица Строителей, д. 25, кв. 12")
                ContactCardColumn(c)
            }
        }
    }
}

data class Contact(
    val name: String,
    val patronymic: String,
    val surname: String,
    val phone: String,
    val address: String,
    val favorite: Boolean = false
)

//1
@Composable
fun ContactColumnScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EE))
                .padding(vertical = 12.dp, horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "FirstComposeProject",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(text = "Имя: Евгений")
            Text(text = "Отчество: Андреевич")
            Text(text = "Фамилия: Лукашин")
            Text(text = "Мобильный телефон: +7 495 495 95 95")
            Text(text = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
        }
    }
}

@Preview(showBackground = true, name = "ContactColumnPreview")
@Composable
fun ContactColumnPreview1() {
    ContactColumnScreen()
}

//2
@Composable
fun ContactsListColumn(
    contacts: List<Contact>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "FirstComposeProject",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EE))
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )

        Spacer(Modifier.height(8.dp))

        contacts.forEachIndexed { index, contact ->
            ContactCardColumn(contact, Modifier.fillMaxWidth())
            if (index != contacts.lastIndex) Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
fun ContactCardColumn(
    contact: Contact,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFD9D9D9),
        tonalElevation = 1.dp,
        shadowElevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: ${contact.name}")
            Text("Отчество: ${contact.patronymic}")
            Text("Фамилия: ${contact.surname}")
            Text("Мобильный телефон: ${contact.phone}")
            Text("Адрес: ${contact.address}")
        }
    }
}

@Preview(showBackground = true, name = "Column — список контактов")
@Composable
fun ListPreview() {
    val demo = listOf(
        Contact("Евгений","Андреевич","Лукашин","+7 495 495 95 95","г. Москва, 3-я улица Строителей, д. 25, кв. 12"),
        Contact("Василий","Егорович","Кузьмин","—","Ивановская область, дер. Крутово, д. 4"),
        Contact("Людмила","Прокофьевна","Калугина","+7 495 788 78 78","Москва, Большая Никитская, д. 43, кв. 290")
    )
    ContactsListColumn(demo)
}

//3
@Composable
fun ContactRowCard(
    contact: Contact,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFD9D9D9)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Имя: ${contact.name}", fontWeight = FontWeight.SemiBold)
                Text("Отчество: ${contact.patronymic}")
                Text("Фамилия: ${contact.surname}")
                Text("Мобильный телефон: ${contact.phone}")
                Text("Адрес: ${contact.address}")
            }

            Spacer(Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Избранное",
                tint = if (contact.favorite) Color(0xFFFF9800) else Color.Gray
            )
        }
    }
}

@Composable
fun SingleRowScreen(contact: Contact) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "FirstComposeProject",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF6200EE))
                .padding(vertical = 12.dp, horizontal = 16.dp)
        )
        Spacer(Modifier.height(8.dp))
        ContactRowCard(contact)
    }
}

@Preview(showBackground = true, name = "Row — карточка с иконкой справа")
@Composable
fun ContactColumnPreview() {
    SingleRowScreen(
        Contact(
            name = "Евгений",
            patronymic = "Андреевич",
            surname = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            favorite = true
        )
    )
}
