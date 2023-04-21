<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

    $(function (){
      login_form.init();
    });

</script>
<style>
  body {font-family: Arial, Helvetica, sans-serif;}
  form {border: 3px solid #f1f1f1;}

  input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }

  button {
    background-color: #04AA6D;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
  }

  button:hover {
    opacity: 0.8;
  }

  .cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
  }

  .imgcontainer {
    text-align: center;
    width: 100%;
    margin: 24px 0 12px 0;
  }

  img.avatar {
    width: 20%;
    border-radius: 50%;
  }
  #login_btn{
    background-color: #04AA6D;

  }
  .container {
    padding: 16px;
    width: 100%;
  }

  span.psw {
    float: right;
    padding-top: 16px;
  }

  /* Change styles for span and cancel button on extra small screens */
  @media screen and (max-width: 300px) {
    span.psw {
      display: block;
      float: none;
    }
    .cancelbtn {
      width: 100%;
    }
  }
</style>
<!-- css end -->
<!-- html start -->
<div class="col-sm-8 text-left">
  <div class="container">
<%--   // <h2>Login Form</h2>--%>

    <form id="login_form" class="form-horizontal well">
      <div class="imgcontainer">
        <img src="https://www.w3schools.com/howto/img_avatar2.png "alt="Avatar" class="avatar">
      </div>

      <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="id" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="pwd" required>


      </div>
      <button id="login_btn" type="button" class="btn btn-default">Login</button>
      <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
      </div>
    </form>

</div>
</div>