package com.whatsappaphaclone.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.whatsappaphaclone.whatsappclone.ui.ChatListScreen
import com.whatsappaphaclone.whatsappclone.ui.ProfileScreen
import com.whatsappaphaclone.whatsappclone.ui.SignupScreen
import com.whatsappaphaclone.whatsappclone.ui.SingleChatScreen
import com.whatsappaphaclone.whatsappclone.ui.SingleStatusScreen
import com.whatsappaphaclone.whatsappclone.ui.theme.WhatsappCloneTheme


sealed class DestinagionScreen(val route: String){
    object Signup:      DestinagionScreen("signup")
    object Login:       DestinagionScreen("login")
    object Profile:     DestinagionScreen("profile")
    object Chatlist:    DestinagionScreen("chatlist")
    object SingleChat:  DestinagionScreen("singleChat/{chatId}"){
        fun createRoute(id: String)= "singleChat/$id"
    }
    object StatusList:   DestinagionScreen("statusList")
    object SingleStatus: DestinagionScreen("singleStatus/{statusId}"){
        fun createRoute(id: String) = "singleStatus/$id"
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsappCloneTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ChatAppNavigation()
                }
            }
        }
    }
}

@Composable
fun ChatAppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinagionScreen.Signup.route){
        composable(DestinagionScreen.Signup.route){
            SignupScreen()
        }
        composable(DestinagionScreen.Login.route){
            LoginScreen()
        }
        composable(DestinagionScreen.Profile.route){
            ProfileScreen()
        }
        composable(DestinagionScreen.SingleStatus.route){
            SingleStatusScreen(statusId = "123")
        }
        composable(DestinagionScreen.Chatlist.route){
            ChatListScreen()
        }
        composable(DestinagionScreen.SingleChat.route){
            SingleChatScreen(chatId = "123")
        }
    }
}