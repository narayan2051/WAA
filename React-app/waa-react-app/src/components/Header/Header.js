import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import { useState } from "react/cjs/react.development";
import { HTTPClient, loggedInUser } from "../../api/API";
import "./Header.css";

const Header = (props) => {
  const [username, setUsername] = useState("");
  useEffect(() => {
    getUser();
  }, []);

  const getUser = () => {
    HTTPClient.get(loggedInUser)
      .then((response) => {
        setUsername(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="header">
      <div>
        <Link to="/posts">
        Posts
        </Link>
      </div>
      <div>
        <Link to="/add-post">
         New Post
        </Link>
      </div>
      {username && (
        <div className="header">
          <div>
            <Link to="#">profile</Link>
          </div>
          <div>
             Welcome {username}
          </div>
        </div>
      )}
    </div>
  );
};

export default Header;
