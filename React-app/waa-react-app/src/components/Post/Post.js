import React, { useContext } from "react";
import { useState } from "react/cjs/react.development";
import { PostData } from "../Context/PostData";
import "./Post.css";

const Post = (props) => {
  const handleClickContext = useContext(PostData);
  const [follow, setFollow] = useState("Follow");
  
  const handleClick = (event) => {
    if (follow === "Follow") {
      setFollow("Unfollow");
    } else {
      setFollow("Follow");
    }
    event.stopPropagation();
  };
  return (
    <div className="post" onClick={() => handleClickContext(props.data)}>
      <h3>{props.data?.title}</h3>
      <p>{props.data?.author}</p>
      <div className="follow">
        <button onClick={handleClick}>{follow}</button>
      </div>
    </div>
  );
};

export default Post;
