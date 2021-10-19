bool areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    return (max(yourLeft, yourRight) == max(friendsLeft, friendsRight)) && (min(yourLeft, yourRight) == min(friendsLeft, friendsRight));
}

