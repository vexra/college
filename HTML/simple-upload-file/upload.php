<?php
    if(isset($_POST["submit"])) {
        $target_dir = "uploads/";
        $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
    
        move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Display Uploaded Files</title>
</head>
<body>
    <main class="flex items-center justify-center flex-col p-4 gap-4">
        <h1 class="text-xl font-semibold">Uploaded Files</h1>
        <p class="text-lg">Click the file to download</p>

        <?php
        $files = glob("uploads/*");
        foreach($files as $file) {
            echo "<a href='$file' download class='px-4 py-2 rounded-lg bg-blue-500 text-zinc-50'>".basename($file)."</a><br>";
        }
        ?>
    </main>
</body>
</html>