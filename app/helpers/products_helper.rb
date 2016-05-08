module ProductsHelper
  def color_score(score)
    if score > 75
      data = "<div class=\"score_green\">#{score.round}</div>"
    elsif score > 50
      data = "<div class=\"score_yellow\">#{score.round}</div>"
      else data = "<div class=\"score_red\">#{score.round}</div>"
    end
    data.html_safe
  end

end
