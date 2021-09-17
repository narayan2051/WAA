import React, { useState } from "react";
import { HTTPClient, postUrl } from "../../../api/API";
import Header from "../../Header/Header";
import "./AddPost.css";

const AddPost = (props) => {
  const [postData, setPostData] = useState({
    title: "",
    content: "",
    author: "",
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    HTTPClient.post(postUrl, postData)
      .then((response) => {
        props.history.push("/posts");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      <form className="addPost" onSubmit={handleSubmit}>
        <div>
          <label>Post Title</label>
          <input
            type="text"
            onChange={(event) =>
              setPostData({ ...postData, title: event.target.value })
            }
          />
          <label>Post Content</label>
          <input
            type="text"
            onChange={(event) =>
              setPostData({ ...postData, content: event.target.value })
            }
          />
          <label>Author</label>
          <select
            onChange={(event) =>
              setPostData({ ...postData, author: event.target.value })
            }
          >
            <option>Dean</option>
            <option>Narayan</option>
            <option>Sulab</option>
            <option>Max</option>
          </select>
        </div>
        <button type="submit">Save</button>
      </form>
    </>
  );
};

export default AddPost;
