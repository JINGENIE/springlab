<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- css start -->
<script>

  $(function (){
    register_form.init();
  });

</script>
<style>
  body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
  }

  * {
    box-sizing: border-box;
  }

  /* Add padding to containers */
  .container {
    width: 100%;
    padding: 16px;
    background-color: white;
  }

  /* Full-width input fields */
  input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
  }

  input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
  }

  /* Overwrite default styles of hr */
  hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
  }

  /* Set a style for the submit button */
  #register_btn{
    background-color: #04AA6D;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }

  #register_btn:hover {
    opacity: 1;
  }

  /* Add a blue text color to links */
  a {
    color: dodgerblue;
  }

  /* Set a grey background color and center the text of the "sign in" section */
  .signin {
    background-color: #f1f1f1;
    text-align: center;
  }
</style>
<!-- css end -->
<!-- html start -->
<div class="col-sm-8 text-left">
  <!-- form id와 name 다 있어야함-->
  <form id="register_form" name="register_form">
    <div class="container">
      <h1>Register</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for="name"><b>name</b></label>
      <input type="text" placeholder="Enter Name" name="name" id="name" required>
      <label for="id"><b>id</b></label>
      <input type="text" placeholder="Enter Email" name="id" id="id" required>

      <label for="pwd"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="pwd" id="pwd" required>

      <hr>
      <button id="register_btn" class="btn btn-default">Register</button>
      <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    </div>

    <div class="container signin">
      <p>Already have an account? <a href="#">Sign in</a>.</p>
    </div>
  </form>
</div>