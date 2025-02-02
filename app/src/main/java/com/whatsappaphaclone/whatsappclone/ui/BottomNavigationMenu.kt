package com.whatsappaphaclone.whatsappclone.ui

import com.whatsappaphaclone.whatsappclone.DestinationScreen
import com.whatsappaphaclone.whatsappclone.R

enum class BottomNavigationItem(val icon: Int, val navDestination: DestinationScreen) {
    STATUSLIST(R.drawable.baseline_status, DestinationScreen.StatusList),
    CHATLIST(R.drawable.baseline_chat, DestinationScreen.Chatlist),
    PROFILE(R.drawable.baseline_profile, DestinationScreen.Pofile)
}