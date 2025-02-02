package com.whatsappaphaclone.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.whatsappaphaclone.whatsappclone.ui.ChatListScreen
import com.whatsappaphaclone.whatsappclone.ui.ProfileScreen
import com.whatsappaphaclone.whatsappclone.ui.SignupScreen
import com.whatsappaphaclone.whatsappclone.ui.SingleChatScreen
import com.whatsappaphaclone.whatsappclone.ui.SingleStatusScreen
import com.whatsappaphaclone.whatsappclone.ui.StatusListScreen
import com.whatsappaphaclone.whatsappclone.ui.theme.WhatsappCloneTheme
import dagger.hilt.android.AndroidEntryPoint


sealed class DestinationScreen(val route: String){
    object Signup:      DestinationScreen("signup")
    object Login:       DestinationScreen("login")
    object Profile:     DestinationScreen("profile")
    object Chatlist:    DestinationScreen("chatlist")
    object SingleChat:  DestinationScreen("singleChat/{chatId}"){
        fun createRoute(id: String)= "singleChat/$id"
    }
    object StatusList:   DestinationScreen("statusList")
    object SingleStatus: DestinationScreen("singleStatus/{statusId}"){
        fun createRoute(id: String) = "singleStatus/$id"
    }
}

@AndroidEntryPoint
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

    NavHost(navController = navController, startDestination = DestinationScreen.Profile.route){
        composable(DestinationScreen.Signup.route){
            SignupScreen()
        }
        composable(DestinationScreen.Login.route){
            LoginScreen()
        }
        composable(DestinationScreen.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(DestinationScreen.StatusList.route){
            StatusListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleStatus.route){
            SingleStatusScreen(statusId = "123")
        }
        composable(DestinationScreen.Chatlist.route){
            ChatListScreen(navController = navController)
        }
        composable(DestinationScreen.SingleChat.route){
            SingleChatScreen(chatId = "123")
        }
    }
}