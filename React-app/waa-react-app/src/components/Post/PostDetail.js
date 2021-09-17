import React from "react";
import { HTTPClient, postUrl } from "../../api/API";
import "./Post.css";

const PostDetail = (props) => {

  const handleDelete = (id) => {
    HTTPClient.delete(postUrl + "/" + id)
      .then((response) => {
        props.isPostDeleted(true);
      })
      .catch((err) => {
        props.isPostDeleted(false);
        console.log(err);
      });
  };

  return (
    props.data && (
      <section className="postDetail">
        <div>
          <h3>Title:{props.data.title}</h3>
          <h4>Content:{props.data.content}</h4>
          <h5>Author:{props.data.author}</h5>
        </div>
        <button
          className="btn-danger"
          onClick={() => handleDelete(props.data.id)}
        >
          delete
        </button>
      </section>
    )
  );
};
export default PostDetail;
