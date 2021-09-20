import React, { useState } from "react";
import { BASE_URL, HTTPClient } from "../../api/API";
import img from "./download.png";
import "./Login.css";

const Login = (props) => {
  const [formData, setFormData] = useState({ username: "", password: "" });

  const handleSubmit = (e) => {
    e.preventDefault();
    HTTPClient.post(BASE_URL + "/auth", formData)
      .then((respone) => {
        localStorage.setItem("auth", respone.data.token);
        props.history.push("/posts");
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <section>
      <form onSubmit={handleSubmit}>
        <div className="imgcontainer">
          <img src={img} alt="Avatar" className="avatar" />
        </div>

        <div className="container">
          <label>
            <b>Username</b>
          </label>
          <input
            type="text"
            placeholder="Enter Username"
            name="uname"
            required
            value={formData.username}
            onChange={(evnt) =>
              setFormData((prev) => ({ ...prev, username: evnt.target.value }))
            }
          />

          <label>
            <b>Password</b>
          </label>
          <input
            type="password"
            placeholder="Enter Password"
            name="psw"
            value={formData.password}
            onChange={(e) =>
              setFormData((prev) => ({ ...prev, password: e.target.value }))
            }
            required
          />
          <button type="submit">Login</button>
          <label>
            <input type="checkbox" name="remember" /> Remember
            me
          </label>
        </div>

        <div className="container">
          <button type="button" className="cancelbtn">
            Cancel
          </button>
          <span className="psw">
            Forgot <a href="#">password?</a>
          </span>
        </div>
      </form>
    </section>
  );
};

export default Login;
