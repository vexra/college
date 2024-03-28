<?php
    if(isset($_POST["submit"])) {
        $target_dir = "uploads/";
        $target_file = $target_dir . basename($_FILES["imageToUpload"]["name"]);
        $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));

        if ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
        && $imageFileType != "gif" ) {
            echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
        } else {
            move_uploaded_file($_FILES["imageToUpload"]["tmp_name"], $target_file);
            echo "Image uploaded successfully!";
        }
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

        <div class="flex flex-wrap items-center justify-center gap-4">
            <?php
                $images = glob("uploads/*.{jpg,jpeg,png,gif}", GLOB_BRACE);
                foreach($images as $image) {
                    echo "<img src='$image' alt='Uploaded Image' class='object-cover w-96 h-56' /><br>";
                }
            ?>
        </div>
    </main>
</body>
</html>