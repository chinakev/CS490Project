<?php
    /*
     * This script will currently only log into the NJIT servers (without displaying it) & determine if the login was successful
     * Waiting for frontend URL
     */
     
     //Recieve username & password from frontend when it is entered
     $user = $_POST["user"];
     $pass = $_POST["pass"];

     //Test login
    //$user = "andrew";
    //$pass = "kelson";
    
    //This is where the username & password is stored
    //$postData = file_get_contents('php://input');
    $postData = "user=".$user."&pass=".$pass."&uuid=".'0xACA021';
    
    //Initialize cURL
    $ch1 = curl_init();
    $ch2 = curl_init();
    
    //URL that cURL will send to the backend
    $db_url = "https://web.njit.edu/~awk8/CS490BackEnd/HW1LogIn/login.php";
    
    //URL that cURL will access for NJIT
    $njit_url = 'https://cp4.njit.edu/cp/home/login';
    
    //cURL Options for Backend/Database url
    curl_setopt_array($ch1, array(
        CURLOPT_URL => $db_url,
        CURLOPT_POST => true,
        CURLOPT_POSTFIELDS =>  $postData,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_SSL_VERIFYPEER => false,
        CURLOPT_REFERER => $db_url
          ));

        //cURL options for NJIT login
        curl_setopt_array($ch2, array(
        CURLOPT_URL => $njit_url,
        CURLOPT_POST => true,
        CURLOPT_POSTFIELDS =>  $postData,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_FOLLOWLOCATION => true,
        CURLOPT_SSL_VERIFYPEER => false,
        CURLOPT_REFERER => $njit_url
          ));
        
    //Needed to execute the database login
    $output1 = curl_exec($ch1);
    
    //Execute NJIT login
    $output2 = curl_exec($ch2);
    
    //Close cURL
    curl_close($ch1);
    curl_close($ch2);
    
    //Displays the output
    //echo "<br>this is the output:".$output;
    //echo "<br> end ouput";
    
    //Determines if NJIT login was successful
    if(strpos($output2, "Failed") === false){
        echo  "NJIT Login Successful";
    } else{
        echo "NJIT Login Failed";
    }
    
    echo $output1;
    
?>