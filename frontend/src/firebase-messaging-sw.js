importScripts('https://www.gstatic.com/firebasejs/8.0.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.0.2/firebase-messaging.js');


firebase.initializeApp({
    apiKey: "AIzaSyDv9tLRejStW1XHVll7S6FEnW1p7UPx5Mc",
    authDomain: "pwa-project-e9f70.firebaseapp.com",
    projectId: "pwa-project-e9f70",
    storageBucket: "pwa-project-e9f70.appspot.com",
    messagingSenderId: "348229776976",
    appId: "1:348229776976:web:cb4a7deb1e083fab58c355",
    measurementId: "G-G715L8E81N"
});

const messaging = firebase.messaging()