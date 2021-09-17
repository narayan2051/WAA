import React, { useEffect, useState } from "react";
import { HTTPClient, postUrl } from "../../api/API";
import { PostData } from "../Context/PostData";
import Post from "./Post";
import PostDetail from "./PostDetail";
import "./PostList.css";

const PostList = (props) => {
  const [posts, setPosts] = useState([]);
  const [postDetailData, setPostDetailData] = useState(null);

  const handleDeleteAction = (flag) => {
    if(flag){
      getPosts();
      setPostDetailData(null);
    }
  };

  const handlePostClick = (data) => {
    setPostDetailData(data);
  };

  useEffect(() => {
    getPosts();
  }, []);

  const getPosts = () => {
    HTTPClient.get(postUrl)
      .then((resp) => {
        setPosts(resp.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const handleClick = (id) => {
    HTTPClient.get(postUrl + "/" + id)
      .then((resp) => {
        setPostDetailData(resp.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <PostData.Provider value={handlePostClick}>
      <div>
        <div className="postList">
          {posts.map((post) => (
            <Post
              key={post.id}
              data={post}
              handleClick={() => handleClick(post.id)}
            />
          ))}
        </div>
        <PostDetail data={postDetailData} isPostDeleted={handleDeleteAction} />
      </div>
    </PostData.Provider>
  );
};
export default PostList;
