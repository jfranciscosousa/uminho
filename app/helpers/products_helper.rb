module ProductsHelper
  def color_score(score)
    if score > 75
      data = "<div class=\"score_green\">#{score.to_i}</div>"
    elsif score > 50
      data = "<div class=\"score_yellow\">#{score.to_i}</div>"
      else data = "<div class=\"score_red\">#{score.to_i}</div>"
    end
    data.html_safe
  end

end
