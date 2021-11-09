import React from 'react'

const NewsItem = ({
  headline,
  source,
  url,
  summary
}) => {
  return (
    <div>
      <a href={url} target="_blank"> <h3>{ headline }</h3> </a>
      <div>
        Source: <em>{ source }</em>
      </div>
      <div>
        <p>
          { summary }
        </p>
      </div>
    </div>
  )
}

export default NewsItem