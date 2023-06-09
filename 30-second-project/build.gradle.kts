plugins {
    id("base")
}

tasks.register<Copy>("copyMessage") {
    from("my-message.txt")
    into("$buildDir")
}
